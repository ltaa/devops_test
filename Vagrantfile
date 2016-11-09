

hosts = {
	"vmHost0" => "192.168.3.14"
}

Vagrant.configure("2") do |config|
	hosts.each do |name, ip|
		config.vm.box = "ubuntu/trusty64"
		config.vm.hostname = name
		config.vm.network :private_network, ip: ip
		config.vm.synced_folder ".", "/vagrant"
		config.vm.provision :shell, path: "vagrant/bootstrap/bootstrap.sh"
		config.vm.provision "ansible" do |ansible|
    			ansible.verbose = "v"
		  	ansible.playbook = "playbook.yml"
		end
		config.vm.provider "virtualbox" do |v|
			v.name = name
			v.memory = "1024"
			v.cpus = 2
		end
	end
end

