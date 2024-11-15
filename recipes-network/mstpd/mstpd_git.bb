SUMMARY = "Multiple Spanning Tree Protocol Daemon"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4325afd396febcb659c36b49533135d4"

SRCBRANCH = "master"
SRCREV = "20f1c93ec1b0fb9056c1770deadb88f57fb71024"

SRC_URI = " \
  git://github.com/mstpd/mstpd.git;branch=${SRCBRANCH};protocol=https \
"

S = "${WORKDIR}/git"

inherit autotools systemd

EXTRA_OECONF = "--sbindir=/sbin"

CFLAGS += " -DPISM_ENABLE_LOG"
CFLAGS += " -DPRTSM_ENABLE_LOG"
CFLAGS += " -DPACKET_DEBUG"

FILES:${PN} += "${systemd_system_unitdir}/mstpd.service"

SYSTEMD_SERVICE:${PN} = "mstpd.service"
SYSTEMD_AUTO_ENABLE:${PN} = "disable"

do_install:append() {
   rm ${D}${libexecdir}/mstpctl-utils/ifquery

   install -d ${D}${systemd_unitdir}/system
   install -m 0644 ${WORKDIR}/build/utils/mstpd.service ${D}${systemd_unitdir}/system
}