package streamEx4;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx4 {

	public static void main(String[] args) {
		Stream<String[]> strArrStrm = Stream.of(
				new String[] {"abc","def","jkl"},
				new String[] {"ABC","DEF","JKLS"}
				);
		
		Stream<String> StrSrtm = strArrStrm.flatMap(Arrays::stream);
		
		StrSrtm.map(String::toLowerCase)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		System.out.println();
		
		String[] lineArr = {
				"Believe or not It is true",
				"Do or do not There is no try",
				"Do or do not There is no try",
				"나 나 아 가 사 타 바 파 다 파 아아"
		};
		
		
		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line->Stream.of(line.split(" +")))
				.map(String::toLowerCase)
				.distinct()
				.sorted()
				.limit(5)
				.forEach(System.out::println);
		System.out.println();
		
		Stream<String> strStrm1 = Stream.of("AAA","ABC","bBb","Dd");
		Stream<String> strStrm2 = Stream.of("bbb","aaa","ccc","ddd");
		
		Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);
		Stream<String> strStream = strStrmStrm
									.map(s->s.toArray(String[]::new))
									.flatMap(Arrays::stream);
		strStream.map(String::toLowerCase)
					.distinct()
					.forEach(System.out::println);
		System.out.println();
		
		
		
				
	}

}
