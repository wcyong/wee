package org.wcy.wee.objectmapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestObjectMapper {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Test
	public void test01() throws Exception {
		String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

		Student student = MAPPER.readValue(jsonString, Student.class);

		System.out.println(student);

		jsonString = MAPPER.writeValueAsString(student);
		System.out.println(jsonString);

	}

	@Test
	public void test02() throws Exception {
		Student s1 = new Student("a", 1);
		Student s2 = new Student("b", 2);
		Student s3 = new Student("c", 3);

		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);

		String json = MAPPER.writeValueAsString(list);
		System.out.println(json);

		List readValue = MAPPER.readValue(json, List.class);
		System.out.println(readValue);
		Student rs = list.get(0);
		System.out.println(rs);
	}

	@Test
	public void test03() throws Exception {
		Student s1 = new Student("a", 1);
		Student s2 = new Student("b", 2);
		Student s3 = new Student("c", 3);

		Map<Integer, Student> map = new HashMap<>();
		map.put(1, s1);
		map.put(2, s2);
		map.put(3, s3);

		String json = MAPPER.writeValueAsString(map);
		System.out.println(json);

		Map readValue = MAPPER.readValue(json, Map.class);
		System.out.println(readValue);
		Student rs = map.get(1);
		System.out.println(rs);
	}

	@Test
	public void test04() throws Exception {
		Student s = new Student("wwss", 22, new Date());

		String value = MAPPER.writeValueAsString(s);
		System.out.println(value);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// 设置日期格式
		MAPPER.setDateFormat(sdf);
		value = MAPPER.writeValueAsString(s);
		System.out.println(value);

	}

	@Test
	public void test05() throws Exception {
		Student s = new Student("wwss", 22, new Date());

		JsonGenerator jsonGenerator = MAPPER.getFactory().createGenerator(System.out, JsonEncoding.UTF8);
		jsonGenerator.writeObject(s);

	}

	@Test
	public void test06() throws Exception {
		String test = "{\"results\":[{\"objectID\":357,\"geoPoints\":[{\"x\":504604.59802246094,\"y\":305569.9150390625}]},{\"objectID\":358,\"geoPoints\":[{\"x\":504602.2680053711,\"y\":305554.43603515625}]}]}";

		// 将Json串以树状结构读入内存
		JsonNode jsonNode = MAPPER.readTree(test);
		System.out.println(jsonNode);

		// 得到results这个节点下的信息
		jsonNode = jsonNode.get("results");
		System.out.println(jsonNode);

		for (int i = 0; i < jsonNode.size(); i++) {
			System.out.println(jsonNode.get(i).get("objectID").asInt()); // 读取节点下的某个子节点的值
			JsonNode geoNumber = jsonNode.get(i).get("geoPoints");
			System.out.println(geoNumber);
			for (int j = 0; j < geoNumber.size(); j++) // 循环遍历子节点下的信息
			{
				System.out.println(
						geoNumber.get(j).get("x").asDouble() + "  " + geoNumber.get(j).get("y").asDouble());

			}
		}

	}

}
