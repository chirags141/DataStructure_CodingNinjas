package L4_Recursion2;

public class ae1_ReturnSubsequences {
    public static String[] findSubsequences(String str){
        if(str.length() == 0){
            String ans[] = {""};
            return ans;
        }
        String smallAns[] = findSubsequences(str.substring(1));

//        String ans[] = new String[(int) Math.pow(2,str.length())];
        String ans[] = new String[2* smallAns.length];

        int i,k =0;
        for(i = 0;i<smallAns.length;i++){
            ans[k] = smallAns[i];
            k++;
        }

        //  using k for tracking the index in ans array after copying smallAns elements;

        for(i = 0;i<smallAns.length;i++){
            //  ans[i+ smallAns.length]
            ans[k]  = str.charAt(0)+smallAns[i];  //appending first element to the small ans
            k++;
        }
        return ans;

    }

    public static void main(String[] args) {
        String str = "abcd";
        String ans[] = findSubsequences(str);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
