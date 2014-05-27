class Solution:
	#@param s, a string
	#@return a string
	
        def reverseWords(self, s):
            if not(s):
	       return ""

	    words = s.strip().split()
	    words.reverse()
            return " ".join(words)
	
