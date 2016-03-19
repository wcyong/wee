package org.wcy.wee.demo.lucence;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * 索引：判断依据，是否根据该字段做搜索。 存储：判断依据，返回的结果中是否返回该字段。
 * 
 * @author wcyong
 *
 */
public class LucenceTest {

	/**
	 * 创建索引
	 * 
	 * @throws IOException
	 */
	@Test
	public void test01() throws IOException {
		// 创建文档,商品数据
		Document document = new Document();
		// 添加一个long字段，字段名、值、是否存储
		document.add(new LongField("id", 12L, Store.YES));
		// TextField:做索引并且分词
		document.add(new TextField("title", "苹果（Apple）iPhone 6 (A1586) 16GB 金色 移动联通电信4G手机", Store.YES));
		document.add(new LongField("price", 498800L, Store.YES));
		document.add(new StringField("image", "http://image.wee.com/images/2015/05/13/2015051310301558402111.jpg",
				Store.YES));
		document.add(new IntField("status", 1, Store.YES));

		// FSDirectory文件系统的位置
		Directory directory = FSDirectory.open(Paths.get("index"));

		// 定义分词器(标准分词器)
		Analyzer analyzer = new StandardAnalyzer();

		// 索引写入对象的配置
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);

		// 索引写入对象
		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

		// 写入
		indexWriter.addDocument(document);

		indexWriter.close();

	}

	/**
	 * 搜索
	 * 
	 * @throws IOException
	 */
	@Test
	public void testSearch() throws IOException {
		// FSDirectory文件系统的位置
		Directory directory = FSDirectory.open(Paths.get("index"));
		IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(directory));

		// 构造查询对象，设置搜索关键字
		Query query = new TermQuery(new Term("title", "移"));
		// 执行搜索，返回命中的数据
		TopDocs topDocs = searcher.search(query, 10);

		System.out.println("命中数据条数: " + topDocs.totalHits);

		// 遍历结果
		for (ScoreDoc sd : topDocs.scoreDocs) {
			System.out.println("得分: " + sd.score);
			// 获取到文档id
			Integer docId = sd.doc;
			Document document = searcher.doc(docId);

			System.out.println("id：" + document.get("id"));
			System.out.println("标题：" + document.get("title"));
			System.out.println("价格：" + document.get("price"));
			System.out.println("图片：" + document.get("image"));
			System.out.println("状态：" + document.get("status"));
		}
	}

	/**
	 * 分词搜索
	 * 
	 * @throws IOException
	 * @throws ParseException
	 */
	@Test
	public void testSearch2() throws IOException, ParseException {
		// FSDirectory文件系统的位置
		Directory directory = FSDirectory.open(Paths.get("index"));
		IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(directory));

		// 定义分词器(标准分词器)
		Analyzer analyzer = new StandardAnalyzer();
		// 定义查询分析器
		QueryParser parser = new QueryParser("title", analyzer);
		// 构造查询对象，分词查询
		Query query = parser.parse("手机");
		// 执行搜索，返回命中的数据
		TopDocs topDocs = searcher.search(query, 10);
		System.out.println("命中数据条数: " + topDocs.totalHits);
		// 遍历结果
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			System.out.println("得分: " + scoreDoc.score);
			// 获取到文档id
			Integer docId = scoreDoc.doc;
			Document document = searcher.doc(docId);

			System.out.println("id：" + document.get("id"));
			System.out.println("标题：" + document.get("title"));
			System.out.println("价格：" + document.get("price"));
			System.out.println("图片：" + document.get("image"));
			System.out.println("状态：" + document.get("status"));

		}
	}

	/**
	 * 测试IK分词器
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIK() throws Exception {
		// 创建文档,商品数据
		Document document = new Document();
		// 添加一个long字段，字段名、值、是否存储
		document.add(new LongField("id", 12L, Store.YES));
		// TextField:做索引并且分词
		document.add(new TextField("title", "xxx苹果（Apple）iPhone 6 (A1586) 16GB 金色 移动联通电信4G手机", Store.YES));
		document.add(new LongField("price", 498800L, Store.YES));
		document.add(new StringField("image", "http://image.taotao.com/images/2015/05/13/2015051310301558402111.jpg",
				Store.YES));
		document.add(new IntField("status", 1, Store.YES));

		// FSDirectory文件系统的位置
		Directory directory = FSDirectory.open(Paths.get("index"));

		// 定义分词器(IK分词器)
		Analyzer analyzer = new IKAnalyzer();
		// 索引写入对象的配置
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);

		// 先删除原有数据再写入，默认：APPEND
		indexWriterConfig.setOpenMode(OpenMode.CREATE);

		// 索引写入对象
		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

		// 写入
		indexWriter.addDocument(document);

		indexWriter.close();

	}
	
	/**
	 * 分词搜索
	 * 
	 * @throws IOException
	 * @throws ParseException
	 */
	@Test
	public void testSearch3() throws IOException, ParseException {
		// FSDirectory文件系统的位置
		Directory directory = FSDirectory.open(Paths.get("index"));
		IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(directory));

		// 定义分词器(标准分词器)
		Analyzer analyzer = new IKAnalyzer();
		// 定义查询分析器
		QueryParser parser = new QueryParser("title", analyzer);
		// 构造查询对象，分词查询
		Query query = parser.parse("xx");
		// 执行搜索，返回命中的数据
		TopDocs topDocs = searcher.search(query, 10);
		System.out.println("命中数据条数: " + topDocs.totalHits);
		// 遍历结果
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			System.out.println("得分: " + scoreDoc.score);
			// 获取到文档id
			Integer docId = scoreDoc.doc;
			Document document = searcher.doc(docId);

			System.out.println("id：" + document.get("id"));
			System.out.println("标题：" + document.get("title"));
			System.out.println("价格：" + document.get("price"));
			System.out.println("图片：" + document.get("image"));
			System.out.println("状态：" + document.get("status"));

		}
	}
	/**
	 * 造数据
	 * 
	 * @throws IOException
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIK2() throws IOException {

		List<Document> documents = new ArrayList<Document>();
		for (int i = 0; i < 100; i++) {
			// 创建文档,商品数据
			Document document = new Document();
			// 添加一个long字段，字段名、值、是否存储
			document.add(new LongField("id", Long.valueOf(i + 1), Store.YES));
			// TextField:做索引并且分词
			document.add(new TextField("title", i + " 苹果（Apple）iPhone " + i + " (A1586) 16GB 金色 移动联通电信 " + i + "G手机",
					Store.YES));
			document.add(new LongField("price", Long.valueOf(100 * (i + 1)), Store.YES));
			document.add(new StringField("image", "http://image.wee.com/images/2015/05/13/2015051310301558402111.jpg",
					Store.YES));
			document.add(new IntField("status", 1, Store.YES));
			documents.add(document);
		}

		// FSDirectory文件系统的位置
		Directory directory = FSDirectory.open(Paths.get("index"));

		// 定义分词器(IK分词器)
		Analyzer analyzer = new IKAnalyzer();
		// 索引写入对象的配置
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);

		// 先删除原有数据再写入，默认：APPEND
		indexWriterConfig.setOpenMode(OpenMode.CREATE);

		// 索引写入对象
		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

		// 写入
		indexWriter.addDocuments(documents);

		indexWriter.close();

	}

	/**
	 * 测试词条搜索
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTermQuery() throws Exception {
		Query query = new TermQuery(new Term("title", "手机"));
		search(query);
	}

	/**
	 * 范围搜索
	 * 
	 * @throws Exception
	 */
	@Test
	public void testNumericRangeQuery() throws Exception {
		// 设置查询字段、最小值、最大值、最小值是否包含边界，最大值是否包含边界
		Query query = NumericRangeQuery.newLongRange("id", 20L, 40L, true, true);
		search(query);
	}

	/**
	 * 匹配全部
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMatchAllDocsQuery() throws Exception {
		Query query = new MatchAllDocsQuery();
		search(query);
	}

	/**
	 * 测试模糊搜索
	 * 
	 * @throws Exception
	 */
	@Test
	public void testWildcardQuery() throws Exception {
		Query query = new WildcardQuery(new Term("title", "2*g"));
		search(query);
	}

	/**
	 * FuzzyQuery 相似度搜索
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFuzzyQuery() throws Exception {
		Query query = new FuzzyQuery(new Term("title", "etole"), 2);
		search(query);
	}

	public void search(Query query) throws Exception {
		// FSDirectory文件系统的位置
		Directory directory = FSDirectory.open(Paths.get("index"));
		IndexSearcher indexSearcher = new IndexSearcher(DirectoryReader.open(directory));
		// 执行搜索，返回命中的数据
		TopDocs topDocs = indexSearcher.search(query, 10);

		System.out.println("命中数据条数: " + topDocs.totalHits);
		// 遍历结果
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		Integer count = 1;
		for (ScoreDoc scoreDoc : scoreDocs) {
			System.out.println("得分: " + scoreDoc.score);
			// 获取到文档id
			Integer docId = scoreDoc.doc;
			Document document = indexSearcher.doc(docId);
			System.out.println("--------------- " + count + " --------------------");
			System.out.println("id：" + document.get("id"));
			System.out.println("标题：" + document.get("title"));
			System.out.println("价格：" + document.get("price"));
			System.out.println("图片：" + document.get("image"));
			System.out.println("状态：" + document.get("status"));

			count++;

		}
	}
}
