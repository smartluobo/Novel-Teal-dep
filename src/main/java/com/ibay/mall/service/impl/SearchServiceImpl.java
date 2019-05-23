package com.ibay.mall.service.impl;

import com.ibay.mall.pojo.common.SearchResult;
import com.ibay.mall.service.SearchService;
import org.springframework.stereotype.Service;

/**
 * @author allen
 */
@Service
public class SearchServiceImpl implements SearchService {

//	@Value("${ES_CONNECT_IP}")
//	private String ES_CONNECT_IP;
//
//	@Value("${ES_CLUSTER_NAME}")
//	private String ES_CLUSTER_NAME;

	@Override
	public SearchResult search(String key, int page, int size, String sort, int priceGt, int priceLte) {

//		try{
//			Settings settings = Settings.builder()
//					.put("cluster.name", ES_CLUSTER_NAME).build();
//			TransportClient client = new PreBuiltTransportClient(settings)
//					.addTransportAddress(new TransportAddress(InetAddress.getByName(ES_CONNECT_IP), 9300));
//
//			SearchResult searchResult=new SearchResult();
//
//			//设置查询条件
//			QueryBuilder qb = matchQuery("productName",key);
//			//设置分页
//			if (page <=0 ){
//				page =1;
//			}
//			int start=(page - 1) * size;
//
//			//设置高亮显示
//			HighlightBuilder hiBuilder=new HighlightBuilder();
//			hiBuilder.preTags("<a style=\"color: #e4393c\">");
//			hiBuilder.postTags("</a>");
//			hiBuilder.field("productName");
//
//			//执行搜索
//			SearchResponse searchResponse = null;
//
//			if(priceGt>=0&&priceLte>=0&&sort.isEmpty()){
//				searchResponse=client.prepareSearch("item")
//						.setTypes("itemList")
//						.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
//						.setQuery(qb)	// Query
//						.setFrom(start).setSize(size).setExplain(true)	//从第几个开始，显示size个数据
//						.highlighter(hiBuilder)		//设置高亮显示
//						.setPostFilter(QueryBuilders.rangeQuery("salePrice").gt(priceGt).lt(priceLte))	//过滤条件
//						.get();
//			}else if(priceGt>=0&&priceLte>=0&&sort.equals("1")){
//				searchResponse=client.prepareSearch("item")
//						.setTypes("itemList")
//						.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
//						.setQuery(qb)	// Query
//						.setFrom(start).setSize(size).setExplain(true)	//从第几个开始，显示size个数据
//						.highlighter(hiBuilder)		//设置高亮显示
//						.setPostFilter(QueryBuilders.rangeQuery("salePrice").gt(priceGt).lt(priceLte))	//过滤条件
//						.addSort("salePrice", SortOrder.ASC)
//						.get();
//			}else if(priceGt>=0&&priceLte>=0&&sort.equals("-1")){
//				searchResponse=client.prepareSearch("item")
//						.setTypes("itemList")
//						.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
//						.setQuery(qb)	// Query
//						.setFrom(start).setSize(size).setExplain(true)	//从第几个开始，显示size个数据
//						.highlighter(hiBuilder)		//设置高亮显示
//						.setPostFilter(QueryBuilders.rangeQuery("salePrice").gt(priceGt).lt(priceLte))	//过滤条件
//						.addSort("salePrice", SortOrder.DESC)
//						.get();
//			}else if((priceGt<0||priceLte<0)&&sort.isEmpty()){
//				searchResponse=client.prepareSearch("item")
//						.setTypes("itemList")
//						.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
//						.setQuery(qb)	// Query
//						.setFrom(start).setSize(size).setExplain(true)	//从第几个开始，显示size个数据
//						.highlighter(hiBuilder)		//设置高亮显示
//						.get();
//			}else if((priceGt<0||priceLte<0)&&sort.equals("1")){
//				searchResponse=client.prepareSearch("item")
//						.setTypes("itemList")
//						.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
//						.setQuery(qb)	// Query
//						.setFrom(start).setSize(size).setExplain(true)	//从第几个开始，显示size个数据
//						.highlighter(hiBuilder)		//设置高亮显示
//						.addSort("salePrice", SortOrder.ASC)
//						.get();
//			}else if((priceGt<0||priceLte<0)&&sort.equals("-1")){
//				searchResponse=client.prepareSearch("item")
//						.setTypes("itemList")
//						.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
//						.setQuery(qb)	// Query
//						.setFrom(start).setSize(size).setExplain(true)	//从第几个开始，显示size个数据
//						.highlighter(hiBuilder)		//设置高亮显示
//						.addSort("salePrice", SortOrder.DESC)
//						.get();
//			}
//
//
//			SearchHits hits = searchResponse.getHits();
//			//返回总结果数
//			searchResult.setRecordCount(hits.totalHits);
//			List<SearchItem> list=new ArrayList<>();
//			if (hits.totalHits > 0) {
//				for (SearchHit hit : hits) {
//					//总页数
//					int totalPage=(int) (hit.getScore()/size);
//					if((hit.getScore()%size)!=0){
//						totalPage++;
//					}
//					//返回结果总页数
//					searchResult.setTotalPages(totalPage);
//					//设置高亮字段
//					SearchItem searchItem=new Gson().fromJson(hit.getSourceAsString(),SearchItem.class);
//					String productName = hit.getHighlightFields().get("productName").getFragments()[0].toString();
//					searchItem.setProductName(productName);
//					//返回结果
//					list.add(searchItem);
//				}
//			}
//			searchResult.setItemList(list);
//			//client.close();
//
//			return searchResult;
//		}catch (Exception e){
//			e.printStackTrace();
//			throw new XmallException("查询ES索引库出错");
//		}
		return null;
	}
}
