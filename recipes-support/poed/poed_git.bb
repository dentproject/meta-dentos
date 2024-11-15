SUMMARY = "DENT Project PoE agent daemon"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

SRCBRANCH = "main"
SRCREV = "075be47969596c9b76e6c4afede9908c3f08fc03"

SRC_URI = " \
  git://github.com/dentproject/poed.git;branch=${SRCBRANCH};protocol=https \
"

S = "${WORKDIR}/git/dentos-poe-agent"

DEPENDS = "python3-smbus2"