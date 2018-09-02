class MinHeap {
	int arr[];
	int capacity;
	int count;
	int heap_type;

	public MinHeap(int capacity, int heap_type) {
		super();
		this.arr = new int[capacity];
		this.capacity = capacity;
		this.count = 0;
		this.heap_type = heap_type;
	}

	int getParent(int index) {
		if (this.count < 1 || index > this.count - 1)
			return -1;
		return (index - 1) / 2;
	}

	int getLeft(int index) {
		int left = index * 2 + 1;
		if (left > this.count - 1)
			return -1;
		return left;
	}

	int getRight(int index) {
		int right = index * 2 + 2;
		if (right > this.count - 1)
			return -1;
		return right;
	}

	void percolateDown(int index) {
		int left, right, max = index;
		left = getLeft(index);
		right = getRight(index);
		if (left != -1 && this.arr[max] > this.arr[left])
			max = left;
		if (right != -1 && this.arr[max] > this.arr[right])
			max = right;
		if (max != index) {
			int temp = this.arr[index];
			this.arr[index] = this.arr[max];
			this.arr[max] = temp;
			percolateDown(max);
		}
	}

	void insert(int data) {
		this.count++;
		int nextPos = this.count - 1;
		while (nextPos >= 0 && data < this.arr[(nextPos - 1) / 2]) {
			this.arr[nextPos] = this.arr[(nextPos - 1) / 2];
			nextPos = (nextPos - 1) / 2;
		}
		this.arr[nextPos] = data;
	}

}

class TestHeap {
	public static void main(String args[]) {
		int arr[] = { 1, 2, 4, 5, 7, 9, 10, 12 };
		MinHeap heap = new MinHeap(8, 0);
		System.arraycopy(arr, 0, heap.arr, 0, arr.length);
		heap.count = heap.arr.length;
		for (int i = (heap.count - 2) / 2; i >= 0; i--) {
			heap.percolateDown(i);
		}
		for (int i : heap.arr) {
			System.out.println(i);
		}
	}
}
