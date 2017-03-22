//----------------------------------------
// Name: Matt Roland
// Class: CS 1233
// Program: Buffer data structure as fifo
// ---------------------------------------
public class RingBuffer
{
  // Attribute
  private int head; // head of the list(where to remove next element)
  private int tail; // tail of the list (where to ass next element)
  private int count; // number of elements in the list
  private double[] buffer; // contains list of samples

  // Default Constructor
  public RingBuffer()
  {
    head = 0;
    tail = 0;
    count = 0;
  }

  // Overloading Constructor
  public RingBuffer(int capacity)
  {
    buffer = new double[capacity];
    head = 0;
    tail = 0;
    count = 0;
  }

  public int size()  // returns number of elements in the buffer
  {
    return count; // (tail - head) % N
  }

  // Checks if buffer is empty
  public boolean isEmpty()
  {
    return count == 0;
  }

  // Check if buffer is full
  public boolean isFull()
  {
    return count == buffer.length;
  }

  // insert a sample
  public void enqueue(double x)
  {
    if (!isFull())
    {
      buffer[tail] = x;
      tail = (tail + 1) % buffer.length;
      count++;
    }
    else
    {
      System.out.println("Buffer is full...");
      // throw new Exception("Buffer is full");
    }
  }

  // Remove a samples
  public double dequeue() throws Exception
  {
    if (!isEmpty())
    {
      double item = buffer[head];
      head = (head + 1) % buffer.length;
      count--;
      return item;
    }
    else
    {
      System.out.println("Buffer is empty");
      throw new Exception("Buffer is full");
      // return 0.0;
    }
  }

  public int getHead()
  {
    return head;
  }

  public int getTail()
  {
    return tail;
  }

  // Return the head of the list
  public double peak()
  {
    return buffer[head];
  }
}
