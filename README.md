meta-dentos
==============

OpenEmbedded / Yocto layer definining the DENT Project dentOS network operating system (NOS) for disaggregated network switch platforms.

## Description

The current target release for this layer is v5.1 (`styhead`) and v5.2 (`walnascar`).

This layer depends on the following layers:

* `openembedded-core` or Yocto's `poky`
  - https://git.openembedded.org/openembedded-core
  - https://git.yoctoproject.org/poky

* `meta-switchbsp`
  - https://github.com/dentproject/meta-switchbsp.git

* `meta-oe` (part of `meta-openembedded`)
  - https://github.com/openembedded/meta-openembedded.git

* `meta-python` (part of `meta-openembedded`)
  - https://github.com/openembedded/meta-openembedded.git

This layer supports the following `MACHINE` targets which are provided by the special `meta-switchbsp` BSP layer:

* `arm64-all`
* `delta-tn48m`

## Quick Start

You can build an image using the following steps:

1. Clone build system (OE-Core or Poky), this layer, and dependencies. For example:
```
~ $ git clone https://github.com/yoctoproject/poky.git

~ $ git clone https://github.com/openembedded/meta-openembedded.git poky/meta-openembedded

~ $ git clone https://github.com/dentproject/meta-switchbsp.git poky/meta-switchbsp

~ $ git clone <this-repo-url> poky/meta-dentos
```

2. Source `oe-init-build-env` in the build system.

3. Add this layer using `bitbake-layers add-layer` and all dependencies:

```
~/poky/build $ bitbake-layers add-layer ../meta-openembedded/meta-oe
~/poky/build $ bitbake-layers add-layer ../meta-switchbsp
~/poky/build $ bitbake-layers add-layer ../meta-openembedded/meta-python
~/poky/build $ bitbake-layers add-layer ../meta-dentos
```

4. Change `DISTRO` in `conf/local.conf` to the dentOS distribution provided by this layer:

```
~/poky/build $ sed -i '/^DISTRO/c \DISTRO ?= "dentos"' conf/local.conf
```

5. Set `MACHINE` in `conf/local.conf` to one of the supported targets:

```
~/poky/build $ sed -i '/^MACHINE/c \MACHINE ?= "delta-tn48m"' conf/local.conf
```

6. Build a target e.g. `bitbake dentos-image`

```
~/poky/build $ bitbake dentos-image
```