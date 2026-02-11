function solution(n, words) {
    const used = new Set();
    
    used.add(words[0]);
    
    for (let i = 1; i < words.length; i++) {
        
        const prev = words[i - 1];
        const current = words[i];
        
        if (prev[prev.length - 1] !== current[0] || used.has(current)) {
            return [
                (i % n) + 1,
                Math.floor(i / n) + 1
            ];
        }
        
        used.add(current);
    }
    
    return [0, 0];
}
