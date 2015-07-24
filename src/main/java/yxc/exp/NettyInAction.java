package yxc.exp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

public class NettyInAction {
	public static final int PORT = 8899;
	public static final int SIZE = 256;

	private Thread server;
	@Before
	public void setup() throws InterruptedException {
		server = new Thread(() -> {
			EventLoopGroup bossGroup = new NioEventLoopGroup(1);
			EventLoopGroup workerGroup = new NioEventLoopGroup();
			try {
				ServerBootstrap b = new ServerBootstrap();
				b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
						.handler(new LoggingHandler(LogLevel.INFO))
						.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					public void initChannel(SocketChannel ch) throws Exception {
						ChannelPipeline p = ch.pipeline();
						p.addLast(new ObjectEncoder(),
								new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
								new ObjectEchoServerHandler());
					}
				});

				// Bind and start to accept incoming connections.
				try {
					b.bind(PORT).sync().channel().closeFuture().sync();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} finally {
				bossGroup.shutdownGracefully();
				workerGroup.shutdownGracefully();
			}
		});
		server.start();
		TimeUnit.SECONDS.sleep(2);
	}

	@Test
	public void testEcho() throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch) throws Exception {
							ChannelPipeline p = ch.pipeline();
							p.addLast(new ObjectEncoder(),
									new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
									new ObjectEchoClientHandler());
						}
					});

			// Start the connection attempt.
			Channel channel = b.connect("localhost", PORT).sync().channel();
			BeanGenerator bg = new BeanGenerator();
			bg.addProperty("param1", String.class);
			bg.addProperty("param2", Integer.class);
			BeanMap beanmap = BeanMap.create(bg.create());
			channel.writeAndFlush(beanmap);
			channel.close();
		} finally {
			group.shutdownGracefully();
		}
		server.join();
	}
}

class ObjectEchoServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		// Echo back the received object to the client.
		System.out.println(msg);
//		ctx.writeAndFlush(msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		System.out.println("read complete");
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}

class ObjectEchoClientHandler extends ChannelInboundHandlerAdapter {
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) {
//		ctx.writeAndFlush("hello");
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		// Echo back the received object to the server.
		ctx.write(msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
