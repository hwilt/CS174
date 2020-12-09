import numpy as np
import matplotlib.pyplot as plt
import subprocess
import os

for i in range(256):
    plt.clf()
    plt.scatter([-1, 1], [-1, 1]); plt.text(0, 0, chr(i)); 
    f = "{}.png".format(i)
    plt.savefig(f)
    subprocess.call(["convert", f, "-crop", "18x18+324+228", "{}.bmp".format(i)])
    os.remove(f)
