# Copyright (c) 2021. Huang Kaisheng (2020215138@stu.cqupt.edu.cn)

SOURCES = $(shell ls *.java | grep -ve '^[Driver|Helper]')
TEST_SRCS = Driver.java Helper.java

test: $(SOURCES) $(TEST_SRCS)
	javac $(SOURCES) $(TEST_SRCS)

pure: $(SOURCES)
	javac $(SOURCES)

javadoc: $(SOURCES)
	mkdir -p javadoc
	docker run -it --rm -w /srv -v $(shell pwd):/srv openjdk /usr/bin/env LANG=en_US.UTF-8 javadoc -locale en_US -d javadoc $(SOURCES) || env LANG=en_US.UTF-8 javadoc -locale en_US -d javadoc $(SOURCES)

.PHONY: clean
clean:
	rm -f *.class
	rm -rf javadoc
