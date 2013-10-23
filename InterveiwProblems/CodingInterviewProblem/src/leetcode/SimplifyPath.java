package leetcode;


/*
 * in Unix style file system, "." means current path, ".." means parent path.
 * so we use stack.
 * 
 * while string element is "." we ignore it. 
 * while string element is ".." we pop stack.
 * while not "." and not ".." we push it in stack. 
 * note 1, we should to check this. 
 * note 2, in java compare two string we cannot be like this:
 * String a, String b
 * if(a == b){ }
 * we should use if(a.equals(b))
 */
import java.util.LinkedList;
public class SimplifyPath {
	
    public static String simplifyPath(String path) {
        if(path.charAt(0) != '/')
             return "";
        int i = 0;
        LinkedList<String> stack = new LinkedList<String>();
        while(i < path.length()){
            while(i < path.length() && path.charAt(i) == '/') i++; // skip begining "////"
            if(i == path.length()) break; //note1
            int start = i;
            while(i < path.length() && path.charAt(i) != '/') i++;
            String element = path.substring(start, i);
            if(!stack.isEmpty() && element.equals("..")) stack.pop();
            if(!element.equals("..") && !element.equals(".")) stack.push(element);
        }
        if(stack.isEmpty()) return "/";
        StringBuilder simPath = new StringBuilder();
        while(!stack.isEmpty()){
            simPath.append("/" + stack.getLast());
            stack.removeLast();
        }
        return new String(simPath);
     }
    
    
	public static void main(String[] args) {
		String path = "/a/./b/../../c/";
		System.out.println(SimplifyPath.simplifyPath(path));
	}
}
