
# MultiLamp

MultiLamp is simple and easy to use Android library to showcase/highlight the multiple views on the same overlay with some message. 

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
	        implementation 'com.github.ujwalthote:MultiLamp:2.0'
	}

## Usage

    MultiLamp multiLamp = new MultiLamp(activity);
    ArrayList<Target> targets = new ArrayList<>();
    targets.add(new Target(btn1, "This is button 1", MultiLamp.RIGHT, new Circle(40)));
    targets.add(new Target(btn2, "This is button 2", MultiLamp.LEFT, new Circle(40)));
    targets.add(new Target(textView, "This is textview", MultiLamp.TOP, new Rectangle()));
    multiLamp.build(targets);

For demo example, clone this repo and checkout the app module 
