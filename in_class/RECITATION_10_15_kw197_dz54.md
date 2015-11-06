###Recitation October 16, 2015 (dz54 and kw197)

This is a review of the Parser class from Kevin's SLogo code.  

It is quite good.  The only problem is that Kevin is not very good at making his methods private.  (He did it once, but that it one time too many).

Other minor complaints include formatting that can make the code more readable.

For example, in the code below:
```
if (p.getCommand().getClass().getSimpleName().equals("Constant")
				|| p.getCommand().getClass().getSimpleName().equals("ListEnd")) {
			currentNode = p;
			return index;
		} 
```
this long boolean expression can be rewritten as a method.

```
private boolean isDone(ParseTreeNode<Command> p) {
	return p.getCommand().getClass().getSimpleName().equals("Constant")
				|| p.getCommand().getClass().getSimpleName().equals("ListEnd")
}

...

if (isDone) {
	currentNode = p;
	return index;
}  
...
```
This makes the code more readable.

A similar idea can be applied to the following println command in the printTreeInOrder() method:

```
		System.out.println(head.getCommand().getClass().getSimpleName() + " " + ((Command) head.getCommand()).getValue()
				+ "->" + head.getParent().getCommand().getClass().getSimpleName() + " "
				+ ((Command) head.getParent().getCommand()).getValue());
```
The argument of the System.out.println() call can be extracted into a separate method:

```
	private String printNode(ParseTreeNode<Command> head) {
		return head.getCommand().getClass().getSimpleName() + " " + ((Command) head.getCommand()).getValue()
				+ "->" + head.getParent().getCommand().getClass().getSimpleName() + " "
				+ ((Command) head.getParent().getCommand()).getValue();
	}
```
> Written with [StackEdit](https://stackedit.io/).