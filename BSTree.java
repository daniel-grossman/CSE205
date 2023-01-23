
class BSTree<T extends Comparable<T>> implements ITree<T>
{
	
   class Node
   {
       Node left;
       Node right;
       T data;

       public Node(T data)
       {
           this.data = data;
       }  
   }

   Node root = null;
   int size;

   public BSTree()
   {
       size = 0;
   }


   public void insert(T item)
   {
       Node newNode = new Node(item);
       Node temp;

       if (root == null)
       {
           root = newNode;
           this.size++;
       }
       else
       {
           temp = root;
          
           while(true)
           {
               if (item == temp.data)
               {
                   System.out.println("can't add");
                   break;
               }

               if (temp.data.compareTo(item) > 0)
               {
                   if (temp.left == null)
                   {
                       temp.left = newNode;
                       this.size++;
                       break;
                   }
                   else
                       temp = temp.left;
               }
               else
               {
                   if (temp.right == null)
                   {
                       temp.right = newNode;
                       this.size++;
                       break;
                   }
                   else
                       temp = temp.right;  
               }
           }
       }
   }
  
   public boolean containsItem(T item)
   {
       Node temp = this.root;

       while(temp != null)
       {
           if (temp.data.compareTo(item) == 0)
               return true;
           else if (temp.data.compareTo(item) > 0)
               temp = temp.left;
           else
               temp = temp.right;
       }

       return false;
   }

   public int getSize()
   {
       return size;
   }
  
   public void printInOrder()
   {
       System.out.print("The in-order traversal is : ");

       inOrder(this.root);
   }

   public void inOrder(Node root)
   {
       if (root == null)
           return;

       inOrder(root.left);
       System.out.print(root.data + " ");
       inOrder(root.right);
   }

   public String inOrder2(Node root, String str)
   {
       if (root == null)
           return str;

       str = inOrder2(root.left, str);
       str += root.data + " ";
       str = inOrder2(root.right, str);

       return str;      
   }
  
   public String toString()
   {
       String text = "";

       text = inOrder2(this.root, text);

       return text;
   }

}

class DriverClass
{
   public static void main(String args[])
   {
       BSTree<Integer> bst = new BSTree<Integer>();

       int data[] = {3, 5, 6, 8, 2 ,1};

       for (int i = 0; i < 6; i++)
       {
           bst.insert(data[i]);
       }

       bst.printInOrder();

       if (bst.containsItem(4))
       {
           System.out.println("\n\nBST contains 4");
       }
       else
       {
           System.out.println("\n\nBST doesn't contain 4");
       }
       System.out.println("Size of BST : " + bst.getSize());

       System.out.println("\n\nBST in sorted order : " + bst.toString());
   }
}