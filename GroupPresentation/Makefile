class: Group2Player
	mkdir -p build
	cd build && javac -d . ../Group2Player/*.java

.PHONY: test
test: 
	cd build && java Group2Player.Main ../testdata/badapple.grp2

.PHONY: clean
clean:
	rm -rf build
