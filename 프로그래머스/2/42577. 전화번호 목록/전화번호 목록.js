function solution(phone_book) {
//     const hashTable = new Map();
    
//       for (const number of phone_book) {
//         hashTable[number] = true;
//       };

//       for (const number of phone_book) {
//         for (let i = 1; i < number.length; i++) {
//           const prefix = number.substring(0, i);
//           if (hashTable[prefix]) return false;  
//         };
//       };

//     // 전부 통과했다면 true를 반환한다.
//       return true;

//===================================================
    phone_book.sort();

    const isPrefix = phone_book.some((book,idx)=>{
        return phone_book[idx+1]?.startsWith(book);
    })

    return !isPrefix
}