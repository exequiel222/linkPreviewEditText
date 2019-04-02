# LinkPreviewEditText

[![License](https://img.shields.io/badge/License%20-Apache%202-337ab7.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![MinSDK](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![Build Status](https://travis-ci.org/skymansandy/linkPreviewEditText.svg?branch=master)](https://travis-ci.org/skymansandy/linkPreviewEditText)

## A simple Android library for link preview above EditText (Inspired by WhatsApp)


## Features:

 - Simple to use
 
 
# Demonstration
|Demo linkPreviewEditText|
|:---:|
|![](art/demoLinkPreviewEditText.gif)|

 
# Usage
## Dependency:

 
 ```
 dependencies {
      implementation ''
 }
 ```
 
 ## XML Usage
 ```xml
  <in.codeshuffle.scratchcardview.ui.ScratchCardLayout
         android:id="@+id/scratchCard"
         android:layout_width="250dp"
         android:layout_height="250dp"
         android:layout_centerInParent="true"
         app:scratchWidth="40dp"
         app:scratchDrawable="@drawable/your_drawable"
         app:scratchRevealFullAtPercent="100">
 
         <!--Your complex view here-->
  </in.codeshuffle.scratchcardview.ui.ScratchCardLayout>     
 ```
 
 ## Java Usage
 ```java
        //Get view reference
        ScratchCardLayout scratchCardLayout = findViewById(R.id.scratchCard);
        
        //Set the drawable (programmatically)
        scratchCardLayout.setScratchDrawable(getResources().getDrawable(R.drawable.car));
        
        //Set scratch brush width
        scratchCardLayout.setScratchWidth(30f);
        
        //Reveal full layout when some percent of the view is scratched
        scratchCardLayout.setRevealFullAtPercent(40);
 ``` 
 
 ### Listeners available
          
Implement the given interface and override these stuff:

```java

          //Implement this to your class
          yourClass extends someBaseClass implements ScratchListener
          
          //Set the listener
          scratchCardLayout.setScratchListener(this);
            
          //You'll have three main callback methods as scratch listeners
          //Scratch started
          void onScratchStarted();
            
          //Scracth progress (NOTE: not guaranteed to be exact percent. consider it like atleast this much percent has been scratched)
          void onScratchProgress(ScratchCardLayout scratchCardLayout, int atLeastScratchedPercent);
            
          //Scratch completed
          void onScratchComplete();
  ``` 
 
 ## Note
 ```
 - The progress is the value guaranteeing that the mentioned percent is atleast scratched. NOT THE EXACT PERCENTAGE (for performance reasaons)
 ```
 
 License
 -------
 
     Copyright 2019 SkyManSandy
 
     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at
 
        http://www.apache.org/licenses/LICENSE-2.0
 
     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.


## Support on Beerpay
Hey dude! Help me out for a couple of :beers:!

[![Beerpay](https://beerpay.io/skymansandy/linkPreviewEditText/badge.svg?style=beer-square)](https://beerpay.io/skymansandy/linkPreviewEditText)  [![Beerpay](https://beerpay.io/skymansandy/linkPreviewEditText/make-wish.svg?style=flat-square)](https://beerpay.io/skymansandy/linkPreviewEditText?focus=wish)