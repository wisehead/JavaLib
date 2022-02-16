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
--List<IntentResponse.DataBean.RegexLinevBean> regexLinevBeans = intentResponse.getData().stream().map(IntentResponse.DataBean::getRegexLinev).collect(Collectors.toList());
--String data = regexLinevBeans.get(0).getData();
--JSONObject jsonObject = JSONUtil.parseObj(data);
--Integer productId = Integer.valueOf(String.valueOf(jsonObject.get("id")));
--ApiRequest apiRequest = ApiRequest.newInstance().filterEqual(Searchfileds.DATA_ID.getName(), productId);
--ApiResponse<ZhbSearchIndexEntity> intentRes = convertRepositoryData(apiRequest, ZhbSearchIndexEntity.class, ApiRequestPage.newInstance().paging(0, 10));
--List<ZhbSearchIndexEntity> pagedData = Lists.newArrayList(intentRes.getPagedData());
--ZhbSearchIndexEntity zhbSearchIndexEntity = pagedData.get(0);       
--recObj.set("type", zhbSearchIndexEntity.getDataType());             
--recObj.set("productId", zhbSearchIndexEntity.getDataId());          
--recObj.set("title", zhbSearchIndexEntity.getTitle());               
--recObj.set("url", zhbSearchIndexEntity.getSourceUrl());             
--recObj.set("createTime", zhbSearchIndexEntity.getCreateTime());     
--recObj.set("redirectUrl", zhbSearchIndexEntity.getRedirectUrl());   
--recObj.set("summary", zhbSearchIndexEntity.getSummary());           
--recObj.set("dataId", zhbSearchIndexEntity.getId());                 
--String description = zhbSearchIndexEntity.getDescription();         
--if (StrUtil.isNotBlank(description)) {                              
----description = DelTagsUtil.getTextFromHtml(description);         
--}                                                                   
--recObj.set("content", JSONUtil.parse(description));                 
--return recObj;
```