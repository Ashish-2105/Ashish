class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxarea=0;
        int nsr[]=new int[heights.length];
        int nsl[]=new int[heights.length];

        Stack<Integer> s= new Stack<>();

        for(int i=heights.length;i>=0;i--){
            while(!s.isEmpty() &&  heights[s.peek() >= heights[i]]){
                s.pop();

            }
            if(s.isEmpty()){
                nsr[i]=heights.length;

            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        s=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty() &&  heights[s.peek() >= heights[i]]){
                s.pop();

            }
            if(s.isEmpty()){
                nsl[i]=-1;

            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }

        for(int i=0;i<heights.lenght;i++){
            int height = heights[i];
            int width = nsr[i]-nsl[i]-1;
            int currarea = height*width;
            maxarea = Math.max(currarea,maxarea);
        }
        System.out.println(maxarea);


    }
}
