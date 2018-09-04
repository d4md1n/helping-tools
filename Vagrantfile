# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure("2") do |config|
  # The most common configuration options are documented and commented below.
  # For a complete reference, please see the online documentation at
  # https://docs.vagrantup.com.

  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://vagrantcloud.com/search.
  config.vm.box = "peru/ubuntu-18.04-server-amd64"
  config.vm.box_version = "20180801.01"
  config.ssh.forward_x11 = true
  # Disable automatic box update checking. If you disable this, then
  # boxes will only be checked for updates when the user runs
  # `vagrant box outdated`. This is not recommended.
  # config.vm.box_check_update = false

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine. In the example below,
  # accessing "localhost:8080" will access port 80 on the guest machine.
  # NOTE: This will enable public access to the opened port
  # config.vm.network "forwarded_port", guest: 80, host: 8080

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine and only allow access
  # via 127.0.0.1 to disable public access
  # config.vm.network "forwarded_port", guest: 80, host: 8080, host_ip: "127.0.0.1"

  # Create a private network, which allows host-only access to the machine
  # using a specific IP.
  # config.vm.network "private_network", ip: "192.168.33.10"

  # Create a public network, which generally matched to bridged network.
  # Bridged networks make the machine appear as another physical device on
  # your network.
  # config.vm.network "public_network"

  # Share an additional folder to the guest VM. The first argument is
  # the path on the host to the actual folder. The second argument is
  # the path on the guest to mount the folder. And the optional third
  # argument is a set of non-required options.
  config.vm.synced_folder "/Users/vassilis.simeonidis/Documents", "/home/vagrant/vagrant_data"
  #config.vm.synced_folder ".", "/vagrant"

  # Provider-specific configuration so you can fine-tune various
  # backing providers for Vagrant. These expose provider-specific options.
  # Example for VirtualBox:
  #
  # config.vm.provider "virtualbox" do |vb|
  #   # Display the VirtualBox GUI when booting the machine
  #   vb.gui = true
  #
  #   # Customize the amount of memory on the VM:
  #   vb.memory = "1024"
  # end
  #
  # View the documentation for the provider you are using for more
  # information on available options.

  # Enable provisioning with a shell script. Additional provisioners such as
  # Puppet, Chef, Ansible, Salt, and Docker are also available. Please see the
  # documentation for more information about their specific syntax and use.

  config.vm.provision "shell", inline: <<-SHELL

    apt-get update
    apt-get install -y xinit openbox-lxde-session obconf menu obmenu
    mkdir /etc/skel/.config
    cp -R /etc/xdg/openbox /etc/skel
    cp /var/lib/openbox/debian-menu.xml /etc/skel/openbox/debian-menu.xml
    openbox --reconfigure

    apt-get remove -y pcmanfm
    apt-get install -y nautilus
    apt-get install -y gedit htop vim terminology firefox
    apt-get install -y nitrogen git
    apt-get install -y software-properties-common
    apt-get install openjdk-11-jdk

    apt-get install -y snapd
    snap install -y slack --classic
    snap install -y intellij-idea-community --classic
    
    apt-get install -y zsh curl
    sh -c "$(curl -fsSL https://raw.githubusercontent.com/robbyrussell/oh-my-zsh/master/tools/install.sh)"

    echo "PATH=\"$PATH:/snap/bin\" >> /etc/skel/.zshrc

  SHELL

  config.vm.provider "virtualbox" do |v|
    v.gui = true
    v.name = 'my-motori'
    v.memory = 14000
    v.cpus = 6
  end
end
