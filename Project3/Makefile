SOURCES = Expression.java ExpressionToken.java GenericStack.java GenericStackInterface.java MalformedExpressionException.java Operator.java StackException.java
TEST_SRCS = Driver.java Helper.java

pure: $(SOURCES)
	javac $(SOURCES)

test: $(SOURCES) $(TEST_SRCS)
	javac $(SOURCES) $(TEST_SRCS)

javadoc: $(SOURCES)
	mkdir -p javadoc
	docker run -it --rm -w /srv -v $(shell pwd):/srv openjdk /usr/bin/env LANG=en_US.UTF-8 javadoc -locale en_US -d javadoc $(SOURCES) || env LANG=en_US.UTF-8 javadoc -locale en_US -d javadoc $(SOURCES)

.PHONY: clean
clean:
	rm -f *.class
	rm -rf javadoc
