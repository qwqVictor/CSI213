#!/usr/bin/env python3
import struct
import sys
title=input().encode('UTF-8')
lines=[]
frames=[]
frame=b""
height=0
lineCount=0
width=0
while len(title) < 60:
	title += b'\0'
with open(sys.argv[1]) as f:
	lines = f.read().split("\n")
for line in lines:
	if line.find(r"%line") == -1:
		lineCount+=1
		width = max(width, len(line))
		height = max(lineCount, height)
		frame += line.encode("ascii")
	else:
		frames.append(frame)
		lineCount=0
		frame=b""
print("Loaded %d frames" % (len(frames)), file=sys.stderr)
fps=int(sys.argv[2])
header=b'GRP2' + title + struct.pack(">BBBxi", fps, width, height, len(frames))
print(header, file=sys.stderr)
sys.stdout.buffer.write(header)
for frame in frames:
	sys.stdout.buffer.write(frame)
sys.stdout.flush()