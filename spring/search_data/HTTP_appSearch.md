#1.appSearch

```
appSearch
--zhbSearchService.appSearch(keyword, sortedType, 0, 30, searchType)
----apiRequest = ApiRequest.newInstance();
----weightMap.put(Searchfileds.TITLE.getName(), 0.9f);     
----weightMap.put(Searchfileds.CONTENT.getName(), 0.1f);   
----weightMap.put(Searchfileds.SUMMARY.getName(), 0.9f);                                                  
----apiRequest.filterMultiMatchWithWeight(weightMap, replaceKeyWord);
----requestIntent(keyword)

```

#2.requestIntent

```
requestIntent
--HttpUtil.get(intentUrl, params, 1000);
--intentResponse = JSONUtil.toBean(s, IntentResponse.class);

```