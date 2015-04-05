# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

Vagrant.require_version ">= 1.7.0"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  if Vagrant.has_plugin?("vagrant-cachier")
    config.cache.scope = :box
  end

  if Vagrant.has_plugin?("vagrant-omnibus")
    config.omnibus.chef_version = :latest
  end

  config.vm.box = "ubuntu/trusty64"

  config.vm.network "forwarded_port", guest: 5005, host: 5005

  config.vm.provider :virtualbox do |v|
    v.memory = 2048
    v.cpus = 2
  end

  config.vm.provision :chef_zero do |chef|
    chef.add_recipe :git
    chef.add_recipe :maven
    chef.add_recipe :'sbt-extras'
    chef.json = {
        :java => {
            :jdk_version => '6'
        }
    }
  end

  config.ssh.forward_agent
end
