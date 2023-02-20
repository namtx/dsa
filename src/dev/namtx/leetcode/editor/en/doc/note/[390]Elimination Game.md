- [Refer](https://leetcode.com/problems/elimination-game/solutions/87119/java-easiest-solution-o-logn-with-explanation/)

> My idea is to update and record head in each turn. when the total number becomes 1, head is the only number left. 
> When will head be updated? 
> if we move from left 
> if we move from right and the total remaining number % 2 == 1 
> like 2 4 6 8 10, we move from 10, we will take out 10, 6 and 2, head is deleted and move to 4 
> like 2 4 6 8 10 12, we move from 12, we will take out 12, 8, 4, head is still remaining 2 then we find a rule to update our head.
>

