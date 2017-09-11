#!/usr/bin/bash

while getopts "o:n:" opt; do
	case $opt in
		o)
			old_string="$OPTARG"
			;;
		n)
			new_string="$OPTARG"
			;;
	esac
done

if test -z "$old_string"; then
	echo 'Old string must not be empty!' >&2
	exit 2
fi
if test -z "$new_string"; then
	echo 'New string must not be empty!' >&2
	exit 3
fi

for filename in $(grep -rlI "$old_string" ../docs/product-openshift-kie-server-b[p,r]ms); do
	echo $filename | grep -q '\.adoc$' || continue

	echo -en '\e[1m'
	echo Processing "$filename"
	echo -en '\e[0m'
	grep -Hns --color=always "$old_string" "$filename" | while read -r line_full; do
		line_no="$(echo $line_full | sed -e 's/\x1B\[[0-9;]*[JKmsu]//g' | awk -F\: '{print $2}')"
		line_text="$(printf '%s' "$line_full" | sed -e 's/^[^:]\+:[^:]\+://')"

		echo LINE $line_no:

		echo -en '\e[2m'
		sed $[line_no-1]'q;d' $filename
		echo -en '\e[0m'

		echo "$line_text"

		echo -en '\e[2m'
		sed $[line_no+1]'q;d' $filename
		echo -en '\e[0m'

		read -n 1 -p "Replace with ${new_string}? [y/N] " choice </dev/tty
		echo

		if ! [ "$choice" == "y" -o "$choice" == "Y" ]; then
			continue
		fi

		escaped_new_string="$(echo $new_string | sed -e 's/[/&]/\\&/g')"
		escaped_old_string="$(echo $old_string | sed -e 's/[/&]/\\&/g')"
		sed -i "${line_no}s/${escaped_old_string}/${escaped_new_string}/g" $filename

	done
	test -z "$choice" || echo
done

