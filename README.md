# TimeCalc

A simple time & frequency calculator for Bitwig Studio. This can be useful to
e.g. set the attack and release values of a compressor.

## Install from a release

Download the latest `.bwextension` file from the [releases](https://github.com/ensonic/bitwig-timecalc/releases)
page and copy it into the `Extensions` folder of your Bitwig Studio
installation. 

## Build & install from code

```shell
mvn install
cp target/TimeCalc.bwextension ~/Bitwig\ Studio/Extensions/
```

## Activate the extension

Then go to `Settings > Controller` and add a new one.

Pick `ensonic` as the vendor and select `TimeCalc` as the hardware. The
extension does not have any settings (yet).

Now you'll find the extension at top-left of Bitwig Studio:

![main ui](/docs/main.png)

## Usage

The shown values are based on the current tempo. Simply select the value you
need, copy it and paste it into the device
