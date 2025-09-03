SUMMARY = "DENT Project PoE agent daemon"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

SRCBRANCH = "main"
SRCREV = "075be47969596c9b76e6c4afede9908c3f08fc03"

DEPENDS = "python3-smbus2"
RDEPENDS:${PN} = "bash"

SRC_URI = " \
  gitsm://github.com/dentproject/poed.git;branch=${SRCBRANCH};protocol=https \
"

S = "${WORKDIR}/git/dentos-poe-agent"

do_install:append() {
   install -d ${D}${systemd_unitdir}/system
   install -m 0644 ${S}/lib/systemd/system/poed.service ${D}${systemd_unitdir}/system

   install -d ${D}/opt/poeagent/docs/
   install -m 0644 ${S}/opt/poeagent/docs/Userguide ${D}/opt/poeagent/docs/Userguide

   install -d ${D}/opt/poeagent/platforms/delta/tn48m-poe-r0
   install -m 0755 ${S}/opt/poeagent/platforms/delta/tn48m-poe-r0/poe_platform.py ${D}/opt/poeagent/platforms/delta/tn48m-poe-r0/poe_platform.py

   install -d ${D}/opt/poeagent/platforms/accton/as4224-52p-r0
   install -m 0755 ${S}/opt/poeagent/platforms/accton/as4224-52p-r0/poe_platform.py ${D}/opt/poeagent/platforms/accton/as4224-52p-r0/poe_platform.py

   install -d ${D}/opt/poeagent/platforms/accton/as4564-26p-r0
   install -m 0755 ${S}/opt/poeagent/platforms/accton/as4564-26p-r0/poe_platform.py ${D}/opt/poeagent/platforms/accton/as4564-26p-r0/poe_platform.py

   install -d ${D}/opt/poeagent/drivers
   install -m 0755 ${S}/opt/poeagent/drivers/poe_driver_pd69200.py ${D}/opt/poeagent/drivers/poe_driver_pd69200.py
   install -m 0755 ${S}/opt/poeagent/drivers/poe_driver_pd69200_def.py ${D}/opt/poeagent/drivers/poe_driver_pd69200_def.py

   install -d ${D}/opt/poeagent/bin
   install -m 0755 ${S}/opt/poeagent/bin/poecli.py ${D}/opt/poeagent/bin/poecli.py
   install -m 0755 ${S}/opt/poeagent/bin/poed.py ${D}/opt/poeagent/bin/poed.py

   install -d ${D}/opt/poeagent/inc
   install -m 0755 ${S}/opt/poeagent/inc/poe_common.py ${D}/opt/poeagent/inc/poe_common.py
   install -m 0755 ${S}/opt/poeagent/inc/poe_version.py ${D}/opt/poeagent/inc/poe_version.py
}

FILES:${PN} += "\
   ${systemd_system_unitdir}/poed.service \
   /opt/poeagent/* "
