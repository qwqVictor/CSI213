SOURCES = ADTBag.java ADTInterface.java BagIndexOutOfBoundException.java EmptyADTBagException.java FullADTBagException.java
TEST_SRCS = Driver.java Helper.java

test: $(SOURCES) $(TEST_SRCS)
	javac $(SOURCES) $(TEST_SRCS)

javadoc: $(SOURCES)
	mkdir -p javadoc
	env LANG=en_US.UTF-8 javadoc -d javadoc $(SOURCES)

.PHONY: clean
clean:
	rm -f *.class
	rm -rf javadoc
