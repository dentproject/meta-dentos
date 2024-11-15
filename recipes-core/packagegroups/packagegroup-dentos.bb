DESCRIPTION = "The base dentOS packagegroup"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = "\
    ethtool \
    iproute2 \
    mstpd \
    poed \
"

RRECOMMENDS:${PN} = "\
    ${MACHINE_EXTRA_RRECOMMENDS} \
"
