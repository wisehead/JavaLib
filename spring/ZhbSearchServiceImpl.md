#1.queryTopSearchHotWord

```cpp
queryTopSearchHotWord
--
```

#2.caller

```
main/java/com/elensdata/ai/search/controller/ZhbSearchController.java:        Set<ZSetOperations.TypedTuple<String>> typedTuples = zhbSearchService.queryTopSearchHotWord(start, end, CacheType.HOT_KEY_WORDS);
main/java/com/elensdata/ai/search/controller/ZhbSearchController.java:        Set<ZSetOperations.TypedTuple<String>> typedTuples = zhbSearchService.queryTopSearchHotWord(start, end, CacheType.HOT_CLICK_WORDS);
main/java/com/elensdata/ai/search/service/impl/ZhbSearchServiceImpl.java:    public Set<ZSetOperations.TypedTuple<String>> queryTopSearchHotWord(int start, int end, CacheType type) {
main/java/com/elensdata/ai/search/service/ZhbSearchService.java:    Set<ZSetOperations.TypedTuple<String>> queryTopSearchHotWord(int start, int end, CacheType type);
```