// function solution(sides) {
//     var answer = 2;
//     var max = Math.max(...sides);
//     var temp = 0;
    
//     sides.forEach((item, idx) => {
//         if (max != item) {
//             temp += item;
            
//             if (max < temp) {
//                 answer = 1;
//             } else {
//                 answer = 2;
//             }
//         }
//     })  
    
//     return answer;
// }
function solution(sides) {
    sides = sides.sort((a,b) => a-b)
    return sides[0] + sides[1] > sides[2] ? 1 : 2;
}