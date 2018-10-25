
# MultiLamp

MultiLamp is simple and easy to use Android library used to showcase/highlight the multiple views on the same overlay with some message. 

<img src="https://user-images.githubusercontent.com/12962409/47506382-8baa9200-d88d-11e8-8c93-8b671d72a5cf.png" width="400px"/>

## Gradle

**Step 1 :**   Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}


**Step 2 :** Add the dependency

	dependencies {
	        implementation 'com.github.ujwalthote:MultiLamp:1.0'
	}

## Usage

    MultiLamp multiLamp = new MultiLamp(context, activity);  
    ArrayList<Target> targets = new ArrayList<>();  
    targets.add(new Target(view1, "This is view 1", MultiLamp.RIGHT, new Circle(40, context)));  
    targets.add(new Target(button, "Message 2", MultiLamp.LEFT, new Circle(40, context)));  
    targets.add(new Target(textView, "This is textview", MultiLamp.TOP, new Rectangle(context)));  
    multiLamp.build(targets);

For demo example, clone this repo and checkout the app module 
