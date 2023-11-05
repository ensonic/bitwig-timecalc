# TimeCalc

A simple time & frequency calculator extension for [Bitwig Studio](https://www.bitwig.com).
This can be useful to e.g. set the attack and release values of a compressor.

## Install from a release

Download the latest `.bwextension` file from the [releases](https://github.com/ensonic/bitwig-timecalc/releases)
page and copy it into the `Extensions` folder of your Bitwig Studio
installation:
* Linux: ~/Bitwig Studio/Extensions/
* Mac: ~/Documents/Bitwig Studio/Extensions/
* Windows: %USERPROFILE%\Documents\Bitwig Studio\Extensions\

For Bitwig Studio > 3.4, you can also drag the file from your downloads into the Bitwig Studio window.

## Build & install from code

I am assuming Linux here.

```shell
mvn install
cp target/TimeCalc.bwextension ~/Bitwig\ Studio/Extensions/
```

## Activate the extension

Go to `Settings > Controller` and add a new one. Pick `ensonic` as the vendor
and select `TimeCalc` as the hardware. The extension does not have any settings
(yet).

Now you'll find the extension at top-left of Bitwig Studio:

![main ui](/docs/main.png)

## Usage

The shown values are based on the current tempo. For each note, you get the
duration in ms and the frequency corresponing the wevelength in Hz. Simply
select the value you need, copy it and paste it into the device.

The values are empty, if the audio engine is disabled fro the current project.

## Tutorials

* Odo Sendaidokai: [de](https://www.youtube.com/watch?v=JeCr-3fabak) [en](https://www.youtube.com/watch?v=vma4DL57EjI)
* Polarity Musik: [en](https://www.youtube.com/watch?v=J0682VqS7hM)