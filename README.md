# Load Toast Library

The default toasts are ugly and don't really provide much more than a short message. This small library provides a better toast which will give the user feedback by morphing into a checkmark or cross (success and fail). The lifetime of the toast is completely controlled by you.

# Demo

![](http://i.imgur.com/WwoxLMu.gif)

# Usage

## Step 1

#### Gradle
```groovy
dependencies {
    compile 'net.steamcrafted:load-toast:1.0.9'
}
```

## Step 2

The API is very simple, create a new toast by providing a context:

```java
LoadToast lt = new LoadToast(context);
```

Change the displayed text:

```java
lt.setText("Sending Reply...");
```

If you don't have a message to display, the toast will shrink to only show the circular loader.

Then proceed to show the toast:

```java
lt.show();
```

When your background thingy is done provide feedback to the user and hide the toast:

```java
// Call this if it was successful
lt.success();

// Or this method if it failed
lt.error();
```

If you are using translucent actionbar in a full screen activity it will appear over the actionbar, fortunately there is a method to change the y translation:

```java
lt.setTranslationY(100); // y offset in pixels
```

You can also change the colors of the different toast elements:

```java
lt.setTextColor(Color.RED).setBackgroundColor(Color.GREEN).setProgressColor(Color.BLUE);
```

These can be chained as you can see.

#License

Released under the [Apache 2.0 License](https://github.com/code-mc/loadtoast/blob/master/license.md)
