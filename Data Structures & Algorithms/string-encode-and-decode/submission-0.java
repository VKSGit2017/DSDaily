/*Time Complexity - O(m) for each encode() amd decode() - 
m is the sum of lengths of all strings and n is the no of strings.

Space complexiy - O(m+n)
*/
class Solution {

    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for(String str: strs){
            encode.append(str.length()).append('#').append(str);
        }
        return encode.toString();
    }

    public List<String> decode(String str) {
        List<String> decode = new ArrayList<>();
        int i =0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            i = j+1;
            j = i + len;
            decode.add(str.substring(i,j));
            i = j;
        }
        return decode;
    }
}
