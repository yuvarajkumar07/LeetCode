class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> dabba=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            
            int s=target-nums[i];
            if(dabba.containsKey(s))
            {
                return new int[]{dabba.get(s), i};
            }
            dabba.put(nums[i],i);
        }
        return new int[]{};
    }
}