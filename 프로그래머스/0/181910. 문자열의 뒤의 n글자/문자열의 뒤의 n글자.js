function solution(my_string, n) {
    var answer = '';
    
    var len = my_string.length - n;
    answer = my_string.substring(len)
    
    return answer;
}