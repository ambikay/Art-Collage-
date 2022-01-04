
    public String foo (int n){
        Stack<Integer> s = new Stack<Integer>();
        String result = "";
        for(int i = n; i > 0; i = i/2){
            s.push(i%2);
            //while
        }
        while(!s.isEmpty()){
            result += s.pop();
        }
        return result; 
    }
