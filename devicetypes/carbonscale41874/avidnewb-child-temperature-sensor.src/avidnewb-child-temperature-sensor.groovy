/**
 *	Copyright 2018 SmartThings
 *
 *	Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *	in compliance with the License. You may obtain a copy of the License at:
 *
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software distributed under the License is distributed

 *	on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *	for the specific language governing permissions and limitations under the License.
 *
 */
metadata {
	definition(name: "avidNewb Child Temperature Sensor", namespace: "carbonscale41874", author: "avidNewb", mnmn: "SmartThings", vid: "generic-temperature-measurement", ocfDeviceType: "oic.d.thermostat") {
		capability "Temperature Measurement"
		capability "Health Check"
		capability "Refresh"
		capability "Configuration"
	}

	tiles(scale: 2) {
		multiAttributeTile(name: "temperature", type: "generic", width: 6, height: 4) {
			tileAttribute("device.temperature", key: "PRIMARY_CONTROL") {
				attributeState("temperature", label:'${currentValue}°')
			}
		}

		standardTile("refresh", "device.refresh", inactiveLabel: false, decoration: "flat", width: 2, height: 2) {
			state "default", label:'', action:"refresh.refresh", icon:"st.secondary.refresh"
		}
		main "temperature"
		details(["temperature", "refresh"])
	}
}

def installed() {
	configure()
}

def updated() {
	configure()
}

def configure() {
	parent.configureChild()
	refresh()
}

def ping() {
	refresh()
}

def refresh() {
	parent.refreshChild()
}