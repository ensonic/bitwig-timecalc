# TimeCalc

A simple time & frequency calculator for Bitwig Studio.

## Install from a release

Download the latest bwextension from the [releases](https://github.com/ensonic/bitwig-timecalc/releases)
page and copy it into the `Extensions` folder of your Bitwig Studio
installation. Then go to `Settings > Controller` and add a new controller. Pick
`ensonic` as the vendor and select `TimeCalc`. The extension does not have any
settings (yet).

Now you'll find the extension at top-left of BitWig Studio:

![main ui](/docs/main.png)

## Build & install from code

```shell
mvn install
cp target/TimeCalc.bwextension ~/Bitwig\ Studio/Extensions/
```
