class Solution {

    private static final String[] keypad = {
        "",
        "",
        "abc",
        "def",
        "ghi",  
        "jkl",  
        "mno",  
        "pqrs", 
        "tuv",
        "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.isEmpty()){
            return result;
        }

        StringBuilder currentCombination = new StringBuilder();
        backtrack(digits, 0, currentCombination, result);
        return result;
    }


    public void backtrack(String digits, int idx, StringBuilder currentCombination, List<String> result){

        if(idx == digits.length()){
            result.add(currentCombination.toString());
            return ;
        }

        int digit = digits.charAt(idx) - '0';
        String letters = keypad[digit];

        for(int i = 0; i < letters.length(); i++){
            currentCombination.append(letters.charAt(i));

            backtrack(digits, idx+1, currentCombination, result);

            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}
