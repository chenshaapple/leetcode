package leetcode

class HelloGroovy {
	static class Character {
		int strength
		int wisdom
		
		String toString() {
			"${strength} ${wisdom}"
		}
	}
	static void main(String... args) {
		def chars = [null, new Character(strength: 10, wisdom : 20)]
		for(Character c : chars)
			println c?.getWisdom()
		def writer = new StringWriter();
		def xml = new groovy.xml.MarkupBuilder();
		xml.person(id:2) {
			name 'testName'
			age 1
		}
//		println xml.toString()
	}
	
	private static class SingletonClassInstance {
		private static final instance = new HelloGroovy();
	}
	private HelloGroovy() {
		
	}
	
	HelloGroovy getInstance() {
		return SingletonClassInstance.instance
	}
}
