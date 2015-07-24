package yxc.exp;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarFile;

import org.junit.runners.Parameterized.Parameter;

public class JarAnalyser {
	private String rootPath;

	public JarAnalyser(String path) {
		this.rootPath = path;
	}
	
	public void start() {
		File file = new File(rootPath);
		Deque<File> deque = new LinkedList<>();
		deque.addLast(file);
		while(!deque.isEmpty()){
			int size = deque.size();
			for(int i = 0; i < size; i ++) {
				File curt = deque.pollFirst();
				System.out.println(curt.getName());
				if(!curt.isDirectory()) {
					
				} else{
					for(File next : curt.listFiles(new FileFilter() {
						@Override
						public boolean accept(File pathname) {
							String name = pathname.getName();
							if(pathname.isDirectory() || name.endsWith(".class") || name.endsWith(".jar")) {
								return true;
							}
							return false;
						}
					})){
						deque.addLast(next);
					}
				}
			}
		}
	}
	
	private void handleJavaFile(File file) throws IOException {
		JarFile jarFile = new JarFile(file);
		OutputStream stream = System.out;
		byte[] tmp = new byte[' '];
		stream.write(tmp, 0, 10);
	}
	
	public static void main(String[] args) {
		JarAnalyser jarAnalyser = new JarAnalyser("/Users/apple/git/APMWebServer");
		jarAnalyser.start();
	}
}
