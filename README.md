# Load Toast Library

The default toasts are ugly and don't really provide much more than a short message. This small library provides a better toast which will give the user feedback by morphing into a checkmark or cross (success and fail). The lifetime of the toast is completely controlled by you.

# Demo

![](https://github.com/code-mc/loadtoast/blob/master/ani.gif)

[Demo App](https://github.com/code-mc/loadtoast/blob/master/app/build/outputs/apk/app-debug.apk)

# Usage

## Step 1

#### Gradle
```groovy
dependencies {
    compile 'net.steamcrafted:load-toast:1.0.3'
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

You can also change the colors of the different toast elements:

```java
lt.setTextColor(Color.RED).setBackgroundColor(Color.GREEN).setProgressColor(Color.BLUE);
```

These can be chained as you can see.

#License

Released under the [Apache 2.0 License](https://github.com/code-mc/loadtoast/blob/master/license.md)
