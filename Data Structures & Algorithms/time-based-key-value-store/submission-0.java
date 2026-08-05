class TimeMap {

    private static class Pair{
        String value;
        int timeStamp;

        Pair(String value, int timeStamp){
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timeStamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timeStamp));
    }
    
    public String get(String key, int timeStamp) {
        if(!map.containsKey(key)){
            return "";
        }

        List<Pair> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        String res = "";

        while(left<= right){
            int mid = left + (right - left)/2;

            if(list.get(mid).timeStamp <= timeStamp){
                res = list.get(mid).value;
                left = mid+1;
            }

            else{
                right = mid -1;
            }
        }

        return res;
    }
}
