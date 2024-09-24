pie.jar: Pie.class PieSlicer.class PieView.class
	jar cfe pie.jar PieSlicer *.class

PieSlicer.class: PieSlicer.java PieView.class Pie.class
	javac -g PieSlicer.java

Pie.class: Pie.java
	javac -g Pie.java

PieView.class: PieView.java Pie.class
	javac -g PieView.java
