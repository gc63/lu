import heapq
class Node:
    def __init__(self,freq,symbol,left=None,right=None):
        self.freq=freq
        self.symbol=symbol
        self.left=left
        self.right=right

    def __lt__(self,other):
        return self.freq<other.freq
def tree(chars,freq):
    pq=[]
    for i in range (len(chars)):
        heapq.heappush(pq,Node(freq[i],chars[i]))

    while len(pq)>1:
        left=heapq.heappop(pq)
        right=heapq.heappop(pq)

        new=Node(left.freq+right.freq,None,left,right)

        heapq.heappush(pq,new)

    return pq[0]

def generate_huffman_code(Node,current_code,huffman_code):
    if Node.symbol is not None:
        huffman_code[Node.symbol]=current_code
    else:
        generate_huffman_code(Node.left,current_code +"0",huffman_code)
        generate_huffman_code(Node.right,current_code+"1",huffman_code)

def print_huffman_code(root):
    huffman_code={}
    generate_huffman_code(root,"",huffman_code)
    print("huffman_code")
    for symbol,code in huffman_code.items():
        print(f"{symbol} -> {code}")

def main():
    n=int(input(f"Enter total number of characters: "))
    chars=[]
    freq=[]

    for i in range(n):
        char=input(f"Enter characters {i+1}:")
        chars.append(char)
        f=int(input(f"Enter Frequenchy for {char}:"))
        freq.append(f)

    root=tree(chars,freq)
    print_huffman_code(root)

if __name__ =="__main__":
    main()